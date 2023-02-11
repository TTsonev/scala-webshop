/**
 * @author Trayan Tsonev
 * @id 12127140
 */

object CSVReader {
    def readCSV(): List[StoreItem] = {
        var items = List[StoreItem]()
        val bufferedSource = io.Source.fromFile("data.csv")
        for(line <- bufferedSource.getLines.drop(1)) {
            val cols = line.split(",").map(_.trim)
            val item = new StoreItem(cols(0).toInt, cols(1).toString, cols(2).toInt)
            items = items :+ item
        }
        bufferedSource.close
        items
    }
}

object MainApp {
    def main(args: Array[String]): Unit = {
        val db = new Database()
        val items = CSVReader.readCSV()
        items.foreach(x => db.store(x))

        println("--- SUM UP ---")
        println(db.sumUp())

        println("--- FILTERED BY ASUS ---")
        val asusItems = db.FilterByName("ASUS", db.getItems())
        asusItems.foreach(x => println(x.getName()))
        println(asusItems.length)

        println("--- FILTERED BY Lenovo ---")
        val lenovoItems = db.FilterByName("Lenovo", db.getItems())
        lenovoItems.foreach(x => println(x.getName()))
        println(lenovoItems.length)

        println("--- FILTERED BY HP ---")
        val hpItems = db.FilterByName("HP", db.getItems())
        hpItems.foreach(x => println(x.getName()))
        println(hpItems.length)

        println("--- SORTED ITEMS ---")
        val sortedItems = db.sortByValueDesc()
        sortedItems.foreach(x => println(x.getName() + " " + x.getValue()))

    }
}