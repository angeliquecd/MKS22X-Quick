import java.util.Random;
public class Quick {
  public static int partition(int[] data,int start,int end){
    Random rng = new Random();
    int index=start+(Math.abs(rng.nextInt()%(end-start+1)));//picks random index
    int pivot = data[index];
    //System.out.println(pivot);
    int stored=0;
    data[index]=data[start];
    data[start]=pivot;
    int endy=end;
    for (int inc=0;start+1+inc<=end;inc++){
      if (data[start+1+inc]>pivot){
        stored=data[start+1+inc];
        data[inc+start+1]=data[end];
        data[end]=stored;//swaps with last one
        inc--;
        end--;//so that it doesn't go on forever
      }}
      //printarray(data);}
    //  System.out.println("done parsing");
    for (int i=start+1;i<=endy;i++){
      if (data[i]>pivot){
//System.out.println("in it");
        data[start]=data[i-1];
        data[i-1]=pivot;//finds correct spot
      //  System.out.println(i-1);
        return i-1;
      }
    }
    return endy;
  //  printarray(data);
  }
/*return the value that is the kth smallest value of the array.
 */
 public static int quickselect(int []data, int k){
   selecthelper(data,k,0,data.length-1);}
  public static int selecthelper(int[] data, int k, int start, int end){
   int index = partition(data,start,end);
   if (index==k) return data[index];
   if (index<k){
     partition(data,index,data.length-1);
   }
   if (index>k){
     partition(data,0,index);
   }
 }
}
