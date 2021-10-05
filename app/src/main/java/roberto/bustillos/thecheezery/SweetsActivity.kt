package roberto.bustillos.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class SweetsActivity : AppCompatActivity() {
    var sweets = ArrayList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        agregarProductos()

        var listview: ListView = findViewById(R.id.listview) as ListView
        var adapter: ProductsAdapter = ProductsAdapter(this, sweets)
        listview.adapter = adapter
    }

    fun agregarProductos() {
        sweets.add(Product("Blueberry cake", R.drawable.blueberrycake, "Vanilla cake flavor, topped with cheese topping and blueberries.", 6.0))
        sweets.add(Product("Chocolate cupcake", R.drawable.chocolatecupcake, "Chocolate cupcakes topped with butter cream and cherries", 3.0))
        sweets.add(Product("Lemon tartalette", R.drawable.lemontartalette, "Pastry shell with a lemon flavored filling", 4.0))
        sweets.add(Product("Red Velvet cake", R.drawable.redvelvetcake, "Soft, moist, buttery cake topped with an easy cream cheese frosting.", 6.0))
        sweets.add(Product("Cherry cheesecake", R.drawable. strawberrycheesecake, "This cherry topped cheesecake is positively creamy and delicious and will be your new favorite dessert.", 7.0))
        sweets.add(Product("Tiramisu", R.drawable.tiramisu, "Coffee-flavored Italian dessert", 6.0))

    }

    private class ProductsAdapter: BaseAdapter {
        var products = ArrayList<Product>()
        var context: Context?= null

        constructor(context: Context, products: ArrayList<Product>) {
            this.products = products
            this.context = context
        }

        override fun getCount(): Int {
            return products.size
        }

        override fun getItem(p0: Int): Any {
            return products[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var prod = products[p0]
            var inflater = LayoutInflater.from(context)
            var view = inflater.inflate(R.layout.product_view, null)

            var image = view.findViewById(R.id.product_img) as ImageView
            var name = view.findViewById(R.id.product_name) as TextView
            var desc = view.findViewById(R.id.product_desc) as TextView
            var price = view.findViewById(R.id.product_price) as TextView

            image.setImageResource(prod.image)
            name.setText(prod.name)
            desc.setText(prod.description)
            price.setText("$${prod.price}")
            return view
        }
    }
}