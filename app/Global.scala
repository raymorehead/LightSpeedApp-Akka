package app

import play.api._

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    ClusterSystem.start()
  }

  override def onStop(app: Application)  {
    ClusterSystem.stop()
  }
}