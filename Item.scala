/**
 * @author Trayan Tsonev
 * @id
 */

trait Item {
    var id: Int
    var name: String
    var value: Int

    def setId(x: Int): Unit = {id = x}
    def setName(x: String): Unit = {name = x}
    def setValue(x: Int): Unit = {value = x}

    def getId(): Int = id
    def getName(): String = name 
    def getValue(): Int = value
}
