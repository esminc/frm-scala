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
        <h1>Hello, world!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.

        Await.result(f, Duration.Inf) foreach println

      </body>
    </html>
  }

}
