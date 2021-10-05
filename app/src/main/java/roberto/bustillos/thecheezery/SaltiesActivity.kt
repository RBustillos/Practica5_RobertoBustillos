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

class SaltiesActivity : AppCompatActivity() {
    var salties = ArrayList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        agregarProductos()

        var listview: ListView = findViewById(R.id.listview) as ListView
        var adapter: ProductsAdapter = ProductsAdapter(this, salties)
        listview.adapter = adapter
    }

    fun agregarProductos() {
        salties.add(Product("Chicken crepes", R.drawable.chickencrepes, "Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.", 6.0))
        salties.add(Product("Club Sandwich", R.drawable.clubsandwich, "A delicious sandwich served with french fries.", 5.0))
        salties.add(Product("Panini", R.drawable.hampanini, "Sandwich made with Italian bread  served warmed by grilling.", 4.0))
        salties.add(Product("Philly cheese steak", R.drawable. phillycheesesteak, "Smothered in grilled onions, green peppers, mushrooms, and Provolone.", 6.0))
        salties.add(Product("Nachos", R.drawable. nachos, "Tortilla chips layered with beef and   melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.",  7.0))

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