/**
 * @author Trayan Tsonev
 * @id
 */

class Database() extends ShoppingCart {
    private var storedItems = new Array[StoreItem](0)

    override def store(item: StoreItem): Array[StoreItem] = {
        storedItems = storedItems :+ item
        item.logAction("stored", item.getName)
        storedItems
    }

    override def sumUp(): Int = {
        var res = 0
        storedItems.foreach(x => res = res + x.getValue)
        res
    }

    override def search(name: String): Array[StoreItem] = {
        var res = storedItems.filter(x => x.getName == name)    
        if (res.length > 0) {
           res.foreach(x => x.logAction("found", x.getName))    
        }
        else println(name + " not found.")
        res
    }

    override def delete(id: Int): Array[StoreItem] = {
        if (storedItems.exists(x => x.getId == id)) {              
            var item = storedItems.filter(x => x.getId == id)(0)
            item.logAction("deleted", item.getName) 
        }
        storedItems = storedItems.filter(x => x.getId != id)
        storedItems
    }

    override def sortByValueAsc(): Array[StoreItem] = {
        storedItems = storedItems.sortWith((x1,x2) => x1.getValue < x2.getValue)
        storedItems
    }

    override def sortByValueDesc(): Array[StoreItem] = {
        storedItems = storedItems.sortWith((x1,x2) => x1.getValue > x2.getValue)
        storedItems
    }

    def FilterByName(name: String, items: Array[StoreItem]): Array[StoreItem] = {    
        items.filter(x => x.getName.contains(name)).sortWith((x1,x2) => x1.getValue < x2.getValue).foreach(x => hof(logAction, x.getName))    
    }

    def hof(foo: (String, String) => Unit, item: String) : Unit = {
        foo("placeholderString", item)
    }

    def getItems(): Array[StoreItem] = {storedItems}
}
