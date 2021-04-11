package hr.ferit.famouspersons

import android.app.Application

class FamousPersons : Application() {

    companion object {
        lateinit var application: FamousPersons
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}