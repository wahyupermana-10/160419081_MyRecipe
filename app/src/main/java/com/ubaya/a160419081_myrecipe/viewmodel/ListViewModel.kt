package com.ubaya.a160419081_myrecipe.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ubaya.a160419081_myrecipe.model.Recipe

class ListViewModel:ViewModel() {
    val recipeLD = MutableLiveData<List<Recipe>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh(){
        val recipe1 = Recipe("Rendang"
            , "1 kg daging sapi\n" +
                    "3 butir kelapa, diambil santan kental dan santan encernya\n" +
                    "4 lembar daun jeruk\n" +
                    "3 batang serai, memarkan\n" +
                    "4 butir asam kandis\n" +
                    "100ml minyak goreng\n" +
                    "5 gram garamBumbu rendang daging sapi 1 Kg:\n" +
                    "60 gram bawang merah\n" +
                    "50 gram bawangputih\n" +
                    "250 gram cabai merah besar\n" +
                    "100 gram lengkuas\n" +
                    "50 gram kemiri\n" +
                    "2 gram cengkeh"
            , "1. Haluskan semua bahan Bumbu dengan diulek atau diblender.\n" + "\n" +
                    "2. Tumis bumbu dengan sedikit minyak goreng \n hingga wangi.\n" +
                    "\n" +
                    "3. Masukkan batang serai, daun jeruk, asam kandis dan garam, aduk rata.\n" +
                    "\n" +
                    "4. Tuangi santan dan dididihkan, masukkan daging.\n" +
                    "\n" +
                    "5. Masak dengan api kecil selama beberapa jam sampai daging empuk dan bumbu kecoklatan sesuai selera."
            ,"https://static.tokopedia.net/blog/wp-content/uploads/2018/05/5.-Resep-Rendang-Sapi-Kering.jpg")

        val recipe2 = Recipe("Botok Tawon"
            , "3 buah sarang tawon\n" +
                    "8 Bawang merah\n" +
                    "3 Bawang putih\n" +
                    "6 Kemiri\n" +
                    "secukupnya Tomat / asam / belimbing wuluh\n" +
                    "1 ruas Kencur\n" +
                    "sesuai selera Gula garam penyedap"
            ,"1. Iris iris sarang tawon + tawon kemudian \nsiram dengan air panas secukupnya\n" + "\n"+
                    "2. Haluskan bumbu, siapkan daun pisang, \n kemudian bungkus. Lalu kukus sampai matang"
            ,"https://faktualnews.co/images/2019/02/botok-tawon.png ")

        recipeLD.value = arrayListOf<Recipe>(recipe1,recipe2)
        loadingErrorLD.value = false
        loadingLD.value = true
    }
}