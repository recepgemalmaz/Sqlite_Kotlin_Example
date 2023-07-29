package com.recepgemalmaz.sqliteexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //try & catch

        //sqlite database

        try {

            val veritabani = this.openOrCreateDatabase("Urunler", Context.MODE_PRIVATE, null)
            veritabani.execSQL("CREATE TABLE IF NOT EXISTS urunler (id INTEGER PRIMARY KEY, isim VARCHAR, fiyat INT)")

            //veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('Ayakkabi', 100)")
            //veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('Kazak', 50)")
            //veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('Pantolon', 75)")
            //veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('Gomlek', 25)")
            //veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('Ceket', 150)")


            // ismi gomlek olan 4 numarali id yi atki olarak degisitrme
            //veritabani.execSQL("UPDATE urunler SET isim = 'Atki' WHERE id = 4")



            //id 1 olan ayakkabi fiyatini 200 yap guncelle
            //veritabani.execSQL("UPDATE urunler SET fiyat = 200 WHERE id = 1")


            //id 5 olani sil
            //veritabani.execSQL("DELETE FROM urunler WHERE id = 5")


            

            //icinde o gecenleri getir
            //val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE isim LIKE '%o%'", null)


            //k ile bitenleri getir
            //val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE isim LIKE '%k'", null)

            //A ile balayanlari getir:
            //val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE isim LIKE 'A%'", null)

            //id 3 olani getir
            //val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE id = 3", null)

            //ismi kazak olani getir
            //val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE isim = 'Kazak'", null)

            //urunlerin tumunu getir
            val cursor = veritabani.rawQuery("SELECT * FROM urunler", null)

            val idColumIndex = cursor.getColumnIndex("id")
            val isimColumIndex = cursor.getColumnIndex("isim")
            val fiyatColumIndex = cursor.getColumnIndex("fiyat")

            while (cursor.moveToNext()){

                println("Id: ${cursor.getInt(idColumIndex)}")
                println("Isim: ${cursor.getString(isimColumIndex)}")
                println("Fiyat: ${cursor.getInt(fiyatColumIndex)}")

            }
            cursor.close()

            

        }catch (e: Exception){

            e.printStackTrace()

        }


    }


}