package controllers

import play.api.libs.json._
import play.api.mvc._
import play.api.Play.current
import play.api.libs.ws._

import scala.concurrent.ExecutionContext
import ExecutionContext.Implicits.global

object Application extends Controller {

    implicit object ListOfProjectsFormat extends Format[List[Project]] {
        override def writes(projects: List[Project]): JsValue = JsArray(projects.map( project => JsObject(List("name" -> JsString(project.name)))))
        override def reads(json: JsValue): JsResult[List[Project]] = JsSuccess(json.validate[List[JsValue]].get.map( project => Project((project \ "name").validate[String].get) ))
    }

    def index = Action {
        Ok(views.html.blog())
    }

    def snippets = Action {
        Ok(views.html.blog())
    }

    def projects = Action.async {
        val futureResponse = WS.url("https://api.github.com/orgs/Banana4Life/repos").withRequestTimeout(10000).get()
        val futureProjects = futureResponse.map( response => Json.parse(response.body).as[List[Project]] )
        futureProjects.map( projects => Ok(views.html.projects(projects)) )
    }

    def about = Action {
        Ok(views.html.blog())
    }
}

case class Project(name: String) {

}