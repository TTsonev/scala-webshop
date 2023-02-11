/**
 * @author Trayan Tsonev
 * @id 12127140
 */

class StoreItem(var id: Int, var name: String, var value: Int) extends Item with Logger {
    setId(id)
    setName(name)
    setValue(value)
}