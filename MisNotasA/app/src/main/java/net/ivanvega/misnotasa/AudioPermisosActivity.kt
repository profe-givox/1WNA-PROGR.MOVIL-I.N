package net.ivanvega.misnotasa

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import net.ivanvega.misnotasa.databinding.ActivityAudioPermisosBinding

class AudioPermisosActivity : AppCompatActivity() {
    lateinit var requestPermissionLauncher: ActivityResultLauncher<String>
    lateinit var binding: ActivityAudioPermisosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAudioPermisosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        iniPerm()
        binding.btnGrabar .setOnClickListener { grabar() }
    }

    private fun iniPerm(){
        // Register the permissions callback, which handles the user's response to the
// system permissions dialog. Save the return value, an instance of
// ActivityResultLauncher. You can use either a val, as shown in this snippet,
// or a lateinit var in your onAttach() or onCreate() method.
         requestPermissionLauncher =
            registerForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) { isGranted: Boolean ->
                if (isGranted) {
                    // Permission is granted. Continue the action or workflow in your
                    // app.
                } else {
                    // Explain to the user that the feature is unavailable because the
                    // features requires a permission that the user has denied. At the
                    // same time, respect the user's decision. Don't link to system
                    // settings in an effort to convince the user to change their
                    // decision.
                }
            }

    }

    private fun grabar() {
        revisarPermisos()


    }

    private fun revisarPermisos() {
        when {
            ContextCompat.checkSelfPermission(
                applicationContext,
                "android.permission.RECORD_AUDIO"
            ) == PackageManager.PERMISSION_GRANTED -> {
                // You can use the API that requires the permission.
            }
            /*shouldShowRequestPermissionRationale(...) -> {
            // In an educational UI, explain to the user why your app requires this
            // permission for a specific feature to behave as expected. In this UI,
            // include a "cancel" or "no thanks" button that allows the user to
            // continue using your app without granting the permission.
                //showInContextUI(...)
            }*/
            else -> {
                // You can directly ask for the permission.
                // The registered ActivityResultCallback gets the result of this request.
                requestPermissionLauncher.launch(
                    "android.permission.RECORD_AUDIO")
            }
        }
    }
}