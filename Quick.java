import java.util.Random;
public class Quick {
  public static int partition(int[] data,int start,int end){
    Random rng = new Random();
    int index=start+(Math.abs(rng.nextInt()%(end-start+1)));//picks random index
    int pivot = data[index];
  //  System.out.println("pivot: "+ pivot);
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
      //  System.out.println("returning as index: "+ (i-1));
        return i-1;
      }
    }
      data[start]=data[endy];
    data[endy]=pivot;
    return endy;
  //  printarray(data);
  }
/*return the value that is the kth smallest value of the array.
 */
 public static int quickselect(int []data, int k){
   return selecthelper(data,k,0,data.length-1);
 }
  public static int selecthelper(int[] data, int k, int start, int end){
   int index = partition(data,start,end);
  // System.out.println(index);
  // toString(data);
   if (index==k) return data[index];//you are done
   else if (index<k){
     return selecthelper(data,k,index+1,data.length-1);//only checks stuff to the right
   }
   else if (index>k){
     return selecthelper(data,k,0,index-1);//only checks stuff to the left
   }
   return -1;//unreachable
 }
 public static void toString(int[] data){
   for (int a: data){
     System.out.print(a+" ");
   }
 }
 public static void main (String[] args){
   int[]ary = { 2, 10, 15, 23, 0,  5};
   System.out.println(quickselect(ary,0));//0
   System.out.println(quickselect(ary,1));//2
   System.out.println(quickselect(ary,2));//5
   System.out.println(quickselect(ary,3));//10
   System.out.println(quickselect(ary,4));//15
   System.out.println(quickselect(ary,5));//23
   int[] ary2 = new int[10000];
   Random rng = new Random();

   for (int i=0;i<10000;i++){
     ary2[i]=rng.nextInt()%10000;
   }
    System.out.println(quickselect(ary2,5));//23
 }
}
