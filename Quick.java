import java.util.Random;
public class Quick {
  public static int partition(int[] data,int start,int end){
    Random rng = new Random();
  //  int index=start+(Math.abs(rng.nextInt()%(end-start+1)));//picks random index
    int lowestindex;
    int highestindex;
    System.out.println("\n Starting partition: ");
    toString(data);
    System.out.println("\n \n"+"start: "+start+"end: "+end);
    if (data[start]<data[end])lowestindex=start;
    else lowestindex=end;
    if (data[lowestindex]>data[(end+start)/2]) lowestindex=(end+start)/2;
    //finds lowest value
    if (data[start]>data[end]) highestindex=start;
    else highestindex=end;
    if (data[highestindex]<data[(end+start)/2]) highestindex=(end+start)/2;
    //finds highest value
    if (highestindex==lowestindex) lowestindex=start;
    //  System.out.println("\n"+lowestindex+","+ highestindex);
    int index = start+end+(end+start)/2-lowestindex-highestindex;//median index
  System.out.println("\n index: "+index);
    int pivot = data[index];  System.out.println("pivot: "+ pivot);
    int stored=0;
    data[index]=data[start];
    data[start]=pivot;
    int endy=end;
    int move=-1;
    toString(data);
    //start=start+1;
    for (int inc=0;start+1+inc<=end;inc++){
        // System.out.println("in for loop");
      if (data[start+1+inc]==pivot){
        move = Math.abs(rng.nextInt()%2);//sets a 50% chance of being shifted
      }
      System.out.println("\n"+data[start+1+inc]+"\n");
      if (data[start+1+inc]>pivot ||move==0){
        System.out.println(data[start+1+inc]+">" +pivot);
        stored=data[start+1+inc];
        data[start+1+inc]=data[end];
        data[end]=stored;//swaps with last one
        inc--;
        //start--;
        end--;//so that it doesn't go on forever
      }
      move=-1;
    //  start++;
      System.out.println("new array: ");
      toString(data);
      System.out.println();
    }//printarray(data);
    //  System.out.println("done parsing");
    /*
    stored=data[index];
    if (data[index]>data[start]){
      data[index]=data[start];
      data[start]=stored;
      return start;
    }
    else{
      data[index]=data[start-1];
      data[start-1]=stored;
      return start-1;
    }
  }*/
toString(data);

  //unreachable old code:
    for (int i=endy;i>=0;i--){
      if (data[i]<pivot){//System.out.println("in it");
        data[start]=data[i];
        System.out.println("start is: "+start+" "+data[start]+" "+(data[start]==pivot));
        data[i]=pivot;//finds correct spot
        System.out.println("returning as index: "+ (i));
        return i;
      }
    }
      //data[start]=data[endy];
    //data[endy]=pivot;
    return start;
  //  printarray(data);
  }
/*return the value that is the kth smallest value of the array.
 */
 public static int quickselect(int []data, int k){
   return selecthelper(data,k,0,data.length-1);
 }

  public static int selecthelper(int[] data, int k, int start, int end){
   int index = partition(data,start,end);
   //System.out.println("index: "+index+"\n");
  // toString(data);
   if (index==k) return data[index];//you are done
   else if (index<k){
     return selecthelper(data,k,index+1,end);//only checks stuff to the right
   }
   else if (index>k){
     return selecthelper(data,k,start,index-1);//only checks stuff to the left
   }
   return -1;//unreachable
 }
 /*Modify the array to be in increasing order.
*/
 public static void quicksort(int[] data){
   sorthelper(data,0,data.length-1);
 }
 public static void sorthelper(int[] data, int start, int end){
   if (start>=end) return;
   int index=partition(data,start,end);
   sorthelper(data,index+1,end);
   sorthelper(data,start,index-1);
 }
 public static void toString(int[] data){
   for (int a: data){
     System.out.print(a+" ");
   }
 }
 public static void main (String[] args){
   int[]ary = { 2, 10, 15, 23, 0,  5};
   int[] ary2= {1,0,1,0,0,1,0,1,0,0,0,2,3,4,5 ,6 ,7, 9};/*
   System.out.println("returns: "+ quickselect(ary,0));//0
   System.out.println("returns: "+quickselect(ary,1));//2
   System.out.println("returns: "+quickselect(ary,2));//5
   System.out.println("returns: "+quickselect(ary,3));//10
   System.out.println("returns: "+quickselect(ary,4));//15
   System.out.println("returns: "+quickselect(ary,5));//23
   int[] ary2 = new int[100];
   Random rng = new Random();
   for (int i=0;i<100;i++){
     ary2[i]=rng.nextInt()%10000;
   }
   int [] ary6 = new int[50];
   for (int i=0;i<50;i++){
     ary6[i]=4;
   }
   System.out.println(quickselect(ary6,20)); //1
    System.out.println(quickselect(ary2,5));//23 //2
    int[] ary3 = new int[100000];
    Random rng1 = new Random();
    for (int i=0;i<100000;i++){
      ary3[i]=rng1.nextInt()%10000;
    }//stops working at 1000,000 long array
     System.out.println(quickselect(ary3,35));//23 //3
    int [] ary4 = new int[10000];
    for (int i=0;i<10000;i++){
      ary4[i]= Math.abs(rng.nextInt()%2);
    }
    System.out.println(quickselect(ary4,890)); //4*/
  //  quicksort(ary);
    quicksort(ary2);
    System.out.println();
    toString(ary2);
    //toString(ary);
 }
}
