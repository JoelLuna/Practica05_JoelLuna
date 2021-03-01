package luna.joelmyapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_products.*
import kotlinx.android.synthetic.main.item_product.view.*

class Products : AppCompatActivity() {
    var coldDrinks =  ArrayList<Product>()
   /* var hotDrinks = ArrayList<Product>()
    var sweets = ArrayList<Product>()
    var salties = ArrayList<Product>()*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val bundle = intent.extras

        if(bundle!=null){
            val type=bundle.getString("type")

            when(type){
                "hotDrinks"->{
                    coldDrinks.add(Product("Americano", R.drawable.americano,"Cafe Americano", 5))
                    coldDrinks.add(Product("Latte", R.drawable.latte,"Cafe Americano", 7))
                    coldDrinks.add(Product("Espresso", R.drawable.espresso,"Cafe Americano", 4))
                    coldDrinks.add(Product("HotChocolate", R.drawable.hotchocolate,"Cafe Americano", 5))
                }


                "coldDrinks"->{
                    coldDrinks.add(Product("Caramel Frap", R.drawable.caramelfrap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5))
                    coldDrinks.add(Product("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.",6))
                    coldDrinks.add(Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3))
                    coldDrinks.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4))
                    coldDrinks.add(Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7))
                    coldDrinks.add(Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7))

                }

                "sweets"->{
                    coldDrinks.add(Product("BlueBerryCake",R.drawable.blueberrycake, "Blue Berry como jijos no", 7))
                    coldDrinks.add(Product("RedvelvetCake",R.drawable.redvelvetcake, "Blue Berry como jijos no", 7))
                    coldDrinks.add(Product("StrawBerryCheeseCake",R.drawable.strawberrycheesecake, "Blue Berry como jijos no", 7))
                    coldDrinks.add(Product("Tiramisu",R.drawable.tiramisu, "Blue Berry como jijos no", 7))
                }

                "salties"->{
                    coldDrinks.add(Product("ChickenCrepes",R.drawable.chickencrepes, "Blue Berry como jijos no", 7))
                    coldDrinks.add(Product("Hampaini",R.drawable.hampanini, "Blue Berry como jijos no", 7))
                    coldDrinks.add(Product("Nachos",R.drawable.nachos, "Blue Berry como jijos no", 7))
                    coldDrinks.add(Product("PhillyCheesesteak",R.drawable.phillycheesesteak, "Blue Berry como jijos no", 7))

            }
            }
        }
/*
        cargarHotDrinks()

        cargarSweets()

        cargarSalties()*/

        var adaptador = AdapadorProdutcto(this, coldDrinks)
       /* AdapadorProdutcto(this, hotDrinks)
        AdapadorProdutcto(this, sweets)
        AdapadorProdutcto(this, salties)*/
        list_products.adapter = adaptador

    }
/*
    fun cargarSalties(){
        salties.add(Product("ChickenCrepes",R.drawable.chickencrepes, "Blue Berry como jijos no", 7))
        salties.add(Product("Hampaini",R.drawable.hampanini, "Blue Berry como jijos no", 7))
        salties.add(Product("Nachos",R.drawable.nachos, "Blue Berry como jijos no", 7))
        salties.add(Product("PhillyCheesesteak",R.drawable.phillycheesesteak, "Blue Berry como jijos no", 7))
    }
    fun cargarSweets(){
        sweets.add(Product("BlueBerryCake",R.drawable.blueberrycake, "Blue Berry como jijos no", 7))
        sweets.add(Product("RedvelvetCake",R.drawable.redvelvetcake, "Blue Berry como jijos no", 7))
        sweets.add(Product("StrawBerryCheeseCake",R.drawable.strawberrycheesecake, "Blue Berry como jijos no", 7))
        sweets.add(Product("Tiramisu",R.drawable.tiramisu, "Blue Berry como jijos no", 7))
    }
    fun cargarHotDrinks(){
        hotDrinks.add(Product("Americano", R.drawable.americano,"Cafe Americano", 5))
        hotDrinks.add(Product("Latte", R.drawable.latte,"Cafe Americano", 7))
        hotDrinks.add(Product("Espresso", R.drawable.espresso,"Cafe Americano", 4))
        hotDrinks.add(Product("HotChocolate", R.drawable.hotchocolate,"Cafe Americano", 5))
    }

 */
   /* fun cargarColdDrinks(){

        coldDrinks.add(Product("Caramel Frap", R.drawable.caramelfrap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5))
        coldDrinks.add(Product("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.",6))
        coldDrinks.add(Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3))
        coldDrinks.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4))
        coldDrinks.add(Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7))
        coldDrinks.add(Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7))

    }*/

    private class AdapadorProdutcto: BaseAdapter {
        var contexto: Context?= null
        var productos = ArrayList<Product>()


        constructor(contexto: Context, productos: ArrayList<Product>){
            this.contexto =contexto
            this.productos = productos
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var produ = productos[position]
            var inflator = LayoutInflater.from(contexto)
            var vista = inflator.inflate(R.layout.item_product, null)

            vista.product_name.setText(produ.name)
            vista.product_description.setText(produ.description)
            vista.product_image.setImageResource(produ.image)
            vista.product_price.setText("$${produ.price}")

            return vista
        }

        override fun getItem(position: Int): Any {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return 1
        }

        override fun getCount(): Int {
            return productos.size
        }


    }

}
