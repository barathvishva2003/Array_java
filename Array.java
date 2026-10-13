import java.util.Scanner;
class Array{
    int arr[];
    int size;
    int capacity;
    Array(int capacity){
        arr = new int[capacity];
        this.capacity = capacity;
        size = 0;
    }

   boolean insert(int index, int element){
    if(index < 0 || index > size)
    {
        System.out.print("index is invalid "+index+" ");
        return false;
    }
    if(size >= capacity){
        increacingArray();
    }
      for(int i=size;i>index;i--)
      {
        arr[i]=arr[i-1];
      }
      arr[index]=element;
      size++;
      return true;
   }

   void display(){
    for(int i=0;i<size;i++){
        System.out.print(arr[i]+" ");
    }
    System.out.println();
   }

   int get(int index){
    if(index < 0 || index > size){
        return -9999;
    }
     return arr[index];
   }

   boolean set(int index, int element){
       if(index < 0 || index > size)
       {
        return false;
       }
       arr[index]=element;
       return true;
   }

   boolean delete(int index){
      if(index < 0 || index > size){
        return false;
      }
       for(int i=index ; i<size-1 ; i++){
        arr[i]=arr[i+1];
       }
        size--;
        System.out.print("Element is deleted");
        System.out.println();
        return true;
   }

   int search(int element){
    for(int i=0;i<size;i++){
        if(arr[i]==element){
           return i; 
        }
    }
    System.out.print(" Element not Found ");
    System.out.println();
    return -999;
   }
 
   // Dynamic Array allocation 

   int increacingArray(){ 
    capacity = capacity*2;
    int newArr[] = new int[capacity];
    for(int i=0;i<size;i++){
     newArr[i] = arr[i];
    }
    arr = newArr;
    return 1;
   }

public static void main(String []args){
        
        Scanner ip = new Scanner(System.in);
        System.out.print("Give the Array Size : ");
        int size = ip.nextInt();
        Array arr1 = new Array(size);

       String choice = "yes";

while (choice.equalsIgnoreCase("yes")) { 
    System.out.print("Enter the function name : ");
    int function = ip.nextInt();

    switch (function) {
        case 1:
            for (int i = 0; i < size; i++) {
                System.out.print("Enter the input : ");
                int input = ip.nextInt();
                arr1.insert(i, input);
            }
            break;

        case 2:
            arr1.display();
            break;

        case 3:
            System.out.print("Give the Index value : ");
            int index = ip.nextInt();
            System.out.print("Got the element :"+arr1.get(index));
            System.out.println();
            break;
        
        case 4:
            System.out.print("Give the Index value : ");
            index = ip.nextInt();
            System.out.print("Enter the insert element : ");
            int element = ip.nextInt();
            arr1.set(index, element);
            break;

        case 5:
            System.out.print("Enter the delete index : ");
            int delete = ip.nextInt();
            arr1.delete(delete);
            break;
        
        case 6:
            System.out.print("Enter the element : ");
            int search = ip.nextInt();
            System.out.print("Element exsisting index is : "+arr1.search(search));
            System.out.println();
            break;

        default:
            System.out.println("Invalid function choice.");
            break;
    }

    System.out.print("Do you want to continue 'yes' or 'no' : ");
    choice = ip.next(); 
}
       
        
        
        
    }
}