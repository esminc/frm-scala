package jp.co.esminc

import org.scalatra._
import slick.driver.MySQLDriver.api._
import scala.concurrent.Future
import scala.concurrent.Await
import scala.concurrent.duration.Duration

class HelloWorldServlet extends HelloworldStack {

  get("/") {
     val db = Database.forURL("jdbc:mysql://104.198.91.161/frm", driver="com.mysql.jdbc.Driver", user="root")
    val query = sql"SELECT id, name FROM friends".as[(Int, String)]
    val f:Future[Vector[(Int, String)]] = db.run(query)
            Await.result(f, Duration.Inf) foreach println

    
    <html>
      <body>
        <h1>Friends list</h1>
        
        <p>{ Await.result(f, Duration.Inf) }</p>

      </body>
    </html>
  }

}
