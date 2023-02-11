/**
 * @author Trayan Tsonev
 * @id 
 */

trait Logger {
    def logAction(actionName: String, name: String): Unit = { 
        println(name + " " + actionName)
    }
}
