package com.example.helloworld

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar


class MainActivity2 : AppCompatActivity() {

    private val tvAdapter1 = TVAdapter(this::onItemClick, this::onAddClick)
    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val type = intent.extras?.getInt(MainActivity.KEY_CATEGORY_TYPE)

        println("Current category ${type}")


        val list1 = when (type) {
            Category.TV -> listOf<Element>(
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2F263257_1.webp&w=384&q=100",
                    "Смартфон Samsung Galaxy A03 Core 32GB Black",
                    5,
                    "39 990 ₸"
                ),
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2F255380_1.webp&w=384&q=100",
                    "Смартфон Vivo Y33s 128GB Mirror Black",
                    5,
                    "99 990 ₸"
                ),
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2Fsmartfon_gsm_a17k_64gb_thx_ad_656_8_4_navy_blue_268408_1q.webp&w=384&q=100",
                    "Смартфон OPPO A17k 64GB Navy Blue",
                    5,
                    "59 990 ₸"
                ),
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2F252945_1.webp&w=384&q=100",
                    "Смартфон Apple iPhone 13 128GB Midnight",
                    5,
                    "399 990 ₸"
                ),
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2Fsmartfon_gsm_samsung_sm_a042fzkkskz_thx_65_13_4_galaxy_a04e_128gb_black_269081_1.webp&w=384&q=100",
                    "Смартфон Samsung Galaxy A04e 128GB Black",
                    5,
                    "64 990 ₸"
                ),
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2Fsmartfon_oppo_a57s_128gb_starry_black_267874_1.webp&w=384&q=100",
                    "Смартфон OPPO A57s 128GB Starry Black",
                    5,
                    "109 990 ₸"
                ),
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2F260943_1v.webp&w=384&q=100",
                    "Смартфон Xiaomi Redmi 10C 128GB/4GB Ocean Blue",
                    5,
                    "69 990 ₸"
                ),
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2Fsmartfon_gsm_samsung_sm_a042fzkhskz_thx_65_13_4_galaxy_a04e_64gb_black_269078_1.webp&w=384&q=100",
                    "Смартфон Samsung Galaxy A04e 64GB Black",
                    5,
                    "54 990 ₸"
                ),
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2F258740_1.webp&w=384&q=100",
                    "Смартфон Samsung Galaxy A13 128GB Black",
                    5,
                    "84 990 ₸"
                ),
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2Fsmartfon_gsm_a17k_64gb_thx_ad_656_8_4_blue_268409_1.webp&w=384&q=100",
                    "Смартфон OPPO A17k 64GB Blue",
                    5,
                    "59 990 ₸"
                ),
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2F228942_1.webp&w=384&q=100",
                    "Смартфон Apple iPhone 11 128GB Black",
                    5,
                    "299 990 ₸"
                ),
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2F259679_1.webp&w=384&q=100",
                    "Смартфон Samsung Galaxy A33 128GB Black",
                    5,
                    "129 990 ₸"
                ),

                )
            Category.WM -> listOf<Element>(
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2F259684_1.webp&w=384&q=100",
                    "Стиральная машина с сушкой Bosch WDS28460OE",
                    5,
                    "349 990 ₸"
                ),
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2F136539_1z.webp&w=384&q=100",
                    "Стиральная машина LG F-2M5HS6W",
                    5,
                    "224 990 ₸"
                ),
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2F261231_1.webp&w=384&q=100",
                    "Стиральная машина LG F2J3NS0W",
                    5,
                    "199 990 ₸"
                ),
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2F259584_1.webp&w=384&q=100",
                    "Стиральная машина с сушкой Gorenje W1D2A854ADPS",
                    5,
                    "179 990 ₸"
                ),
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2F263444_1.webp&w=384&q=100",
                    "Стиральная машина LG F2J6HSDS",
                    5,
                    "264 990 ₸"
                ),
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2F259583_1.webp&w=384&q=100",
                    "Стиральная машина Gorenje W1NHEI72SAS",
                    5,
                    "159 990 ₸"
                ),
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2F259582_1.webp&w=384&q=100",
                    "Стиральная машина Gorenje W1NHEI62SAS",
                    5,
                    "144 990 ₸"
                ),
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2F39261_1v.webp&w=384&q=100",
                    "Антивибрационные подставки Eco&clean в коробке, прозрачные круглые AVC-004",
                    5,
                    "2 490 ₸"
                ),
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2F9019615608862.webp&w=384&q=100",
                    "Швейная машина Janome Diva",
                    5,
                    "99 990 ₸"
                ),
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2F219615_1k.webp&w=384&q=100",
                    "Утюг Polaris PIR-2481K",
                    5,
                    "19 990 ₸"
                ),
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2F14363308982302.webp&w=384&q=100",
                    "Стиральная машина LG F-2M5HS6S",
                    5,
                    "239 990 ₸"
                ),
                Element(
                    "https://www.technodom.kz/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F272%2F272%2Fantivibraczionnye_podstavki_ava_vps_001_v_korobke_264074_1.webp&w=384&q=100",
                    "Антивибрационные подставки Ava VPS-001 в коробке",
                    5,
                    "1 590 ₸"
                ),

                )
            Category.CS -> listOf<Element>()
            else -> throw java.lang.IllegalArgumentException("Unknown category type: ${type}")
        }

        findViewById<RecyclerView>(R.id.recycler1).apply {
            val offset = resources.getDimensionPixelOffset(R.dimen.size_4dp)
            addItemDecoration(SquareItemDecoration(offset))

            adapter = tvAdapter1
            tvAdapter1.updateList(list1)
        }

        btn = findViewById<Button>(R.id.btn2).apply {
            setOnClickListener {
            }
        }
    }

    private fun onItemClick(element: Element) {
        val intent = Intent(this, MainActivity3::class.java)
        intent.putExtra("profile", element)
        startActivity(intent)
    }

    private fun onAddClick(element: Element) {
        Snackbar.make(btn, "Добавлено в корзину", Snackbar.LENGTH_SHORT).show()
    }
}
