import play.api._
import play.api.mvc._
import play.api.mvc.Results._
import scala.concurrent.Future

object Global extends WithFilters(WhitespaceFilter) {
  override def onHandlerNotFound(request: RequestHeader) = Future.successful(NotFound("OH NO! -> " + request.uri))
}
