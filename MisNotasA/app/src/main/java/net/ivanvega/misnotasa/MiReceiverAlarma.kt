package net.ivanvega.misnotasa

import android.R
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


class MiReceiverAlarma : BroadcastReceiver() {


    override fun onReceive(p0: Context?, p1: Intent?) {
        p0?.let { createNotificationChannel(it, null) }
        Log.d("DIF-ALARMA", "PERRO-ROJO");
        p0?.let { p1?.let { it1 -> mostrarNotificacion(it, it1) } };
        Log.d("DIF-ALARMA", "NOTIFICACION LANZADA");
    }

    private fun mostrarNotificacion(context: Context, intent: Intent) {
        //createNotificationChannel(context,intent);
        Log.d("DIF-ALARMA", "NOTIFICACION creando");
        // Create an explicit intent for an Activity in your app
        //PendingIntent.FLAG_UPDATE_CURRENT
        val intentTap = Intent(context, MainActivity::class.java)
        intentTap.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        intentTap.putExtra("idTarea", 1002)
        val pendingIntent = PendingIntent.getActivity(
            context, 0,
            intentTap, PendingIntent.FLAG_UPDATE_CURRENT
        )


        val builder: NotificationCompat.Builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_dialog_alert)
            .setContentTitle("Titulo recordatorio")
            .setContentText("Te recuerdo tarea pendiente")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
        val notificationManager = NotificationManagerCompat.from(context)

        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(1001, builder.build())
    }

    companion object{
        val CHANNEL_ID = "RECORDATORIOS-TAREAS"
        fun createNotificationChannel(ctx: Context, intent: Intent?) {
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name: CharSequence = ctx.getString(net.ivanvega.misnotasa.R.string.channel_name)
                val description = ctx.getString(net.ivanvega.misnotasa.R.string.channel_description)
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel(CHANNEL_ID, name, importance)
                channel.description = description
                // Register the channel with the system; you can't change the importance
                // or other notification behaviors after this
                val notificationManager = ctx.getSystemService(
                    NotificationManager::class.java
                )
                notificationManager.createNotificationChannel(channel)
            }
        }
    }



}
