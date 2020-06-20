import com.sun.prism.shader.Solid_TextureSecondPassLCD_AlphaTest_Loader

fun main(){

    var s  = arrayListOf<Int>(3,-1,0,4,5,4,6  )
    var result = 0
    var increase = arrayListOf<Int>()

    for(i in 0..s.size-2){

        if(s[i]<s[i+1]) {
            increase.add(1)
        } else if(s[i]>s[i+1]){
            increase.add(-1)
        }
    }

    for(i in 0..increase.size-2){
        if(increase[i]==increase[i+1]) result++
    }
    if(increase[0]==-1) result++
    println(result)

}