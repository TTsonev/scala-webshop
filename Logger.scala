/**
 * @author Trayan Tsonev
 * @id 12127140
 */

trait Logger {
    def logAction(actionName: String, name: String): Unit = { 
        println(name + " " + actionName)
    }
}
