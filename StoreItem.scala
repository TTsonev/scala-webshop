/**
 * @author Trayan Tsonev
 * @id
 */

class StoreItem(var id: Int, var name: String, var value: Int) extends Item with Logger {
    setId(id)
    setName(name)
    setValue(value)
}
