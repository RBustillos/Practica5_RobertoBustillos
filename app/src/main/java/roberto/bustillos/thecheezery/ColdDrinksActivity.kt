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

class ColdDrinksActivity : AppCompatActivity() {
    var coldDrinks = ArrayList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        agregarProductos()

        var listview: ListView = findViewById(R.id.listview) as ListView
        var adapter: ProductsAdapter = ProductsAdapter(this, coldDrinks)
        listview.adapter = adapter
    }

    fun agregarProductos() {
        coldDrinks.add(Product("Caramel Frap", R.drawable.caramelfrap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5.0))
        coldDrinks.add(Product("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6.0))
        coldDrinks.add(Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3.0))
        coldDrinks.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4.0))
        coldDrinks.add(Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7.0))
        coldDrinks.add(Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7.0))

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