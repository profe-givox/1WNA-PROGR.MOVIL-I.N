package net.ivanvega.misrecyclersview

import android.app.Application
import net.ivanvega.misrecyclersview.data.flowerList

class MiApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DataSource.lsFlower.addAll(flowerList(resources))
    }

}