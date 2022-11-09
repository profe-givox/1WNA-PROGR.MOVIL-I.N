package net.ivanvega.misnotasa

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.media.MediaPlayer.OnPreparedListener
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.MediaController
import android.widget.MediaController.MediaPlayerControl
import androidx.core.content.FileProvider
import net.ivanvega.misnotasa.databinding.ActivityMultimediaCamaraBinding
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class MultimediaCamaraActivity :
    AppCompatActivity(),

    OnTouchListener
    {


    private val REQUEST_VIDEO_CAPTURE: Int = 1001
    lateinit var currentVideoPath: String
    lateinit var photoURI: Uri
    private val REQUEST_IMAGE_CAPTURE: Int = 1000
    lateinit var binding : ActivityMultimediaCamaraBinding

    lateinit var mediaController: MediaController
    //lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultimediaCamaraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.root.setOnTouchListener(this)
        binding.videoView.setOnClickListener { mediaController.show() }
        mediaController = MediaController(this)
        mediaController.setAnchorView(
            binding.root);
        binding.videoView.setMediaController(mediaController)



        binding.btnVideo.setOnClickListener {
            Intent(MediaStore.ACTION_VIDEO_CAPTURE).also { takeVideoIntent ->
                takeVideoIntent.resolveActivity(packageManager)?.also {

                    // Create the File where the photo should go
                    val videoFile: File? = try {
                        createImageFile()
                    } catch (ex: IOException) {
                        // Error occurred while creating the File

                        null
                    }

                    // Continue only if the File was successfully created
                    videoFile?.also {
                        photoURI = FileProvider.getUriForFile(
                            this,
                            "net.ivanvega.misnotasa.fileprovider",
                            it
                        )
                        takeVideoIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                        startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE)
                    }
                }
        }
        }
        binding.btnFoto.setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                takePictureIntent.resolveActivity(packageManager)?.also {

                    // Create the File where the photo should go
                    val photoFile: File? = try {
                        createImageFile()
                    } catch (ex: IOException) {
                        // Error occurred while creating the File

                        null
                    }

                    // Continue only if the File was successfully created
                    photoFile?.also {
                         photoURI = FileProvider.getUriForFile(
                            this,
                            "net.ivanvega.misnotasa.fileprovider",
                            it
                        )
                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }

        }
    }
    }

    lateinit var currentPhotoPath: String

    @Throws(IOException::class)
    fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        //val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val storageDir: File? = filesDir
        return File.createTempFile(
            "JPEG_${timeStamp}_", /* prefix */
            ".jpg", /* suffix */
            storageDir /* directory */
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            currentPhotoPath = absolutePath
            currentVideoPath = absolutePath
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            /*val imageBitmap = data?.extras?.get("data") as Bitmap
            binding.imageViewFotoMiniatura.setImageBitmap(imageBitmap)*/

            //Carga la imagen de manera escalada
            //setPic()

            //Carga la imagen a partir de URI
            binding.imageViewFotoMiniatura.setImageURI(
                photoURI
            )
        }else if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK){



            //binding.videoView.setMediaController(mediaController)
            binding.videoView.setVideoURI(photoURI)

            binding.videoView.start()
            //mediaController.show()



            /*mediaController.setEnabled(true);
            mediaController.show();*/
        }

    }

    private fun setPic() {
        // Get the dimensions of the View
        val targetW: Int = binding.imageViewFotoMiniatura.width
        val targetH: Int = binding.imageViewFotoMiniatura.height

        val bmOptions = BitmapFactory.Options().apply {
            // Get the dimensions of the bitmap
            inJustDecodeBounds = true

            val photoW: Int = outWidth
            val photoH: Int = outHeight

            // Determine how much to scale down the image
            val scaleFactor: Int = Math.min(photoW / targetW, photoH / targetH)

            // Decode the image file into a Bitmap sized to fill the View
            inJustDecodeBounds = false
            inSampleSize = scaleFactor
            inPurgeable = true
        }
        BitmapFactory.decodeFile(currentPhotoPath, bmOptions)?.also { bitmap ->
            binding.imageViewFotoMiniatura.setImageBitmap(bitmap)

        }
    }



    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        mediaController.show()
        return false
    }




}