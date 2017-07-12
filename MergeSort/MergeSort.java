public class MergeSort
{
	public static void mergeSort(int[] a)
	{
		mergeSort(a,new int[a.length], 0, a.length-1);
	}
	public static void mergeSort(int[] a,int[] temp, int leftStart, int rightEnd)
	{
		if(leftStart>=rightEnd)
		{
			return;
		}
		int middle=(leftStart+rightEnd)/2;
		mergeSort(a, temp,leftStart,middle);
		mergeSort(a, temp,middle+1,rightEnd);
		mergeHalves(a, temp, leftStart,rightEnd);	
	}
	public static void mergeHalves(int[] a, int[] temp, int leftStart, int rightEnd)
	{
		int leftEnd=(rightEnd+leftStart)/2;
		int rightStart=leftEnd+1;
		int size=rightEnd-leftStart+1;
		
		int left=leftStart;
		int right=rightStart;
		int index=left;
		
		
		while(left<=leftEnd && right<=rightEnd)
		{
			if(a[left]<=a[right])
			{
				temp[index]=a[left];
				left++;
			}
			else
			{
				temp[index]=a[right];
				right++;
			}
			index++;
		}
		System.arraycopy(a, left, temp, index, leftEnd-left+1);
		System.arraycopy(a, right, temp, index, rightEnd-right+1);
		System.arraycopy(temp, leftStart, a, leftStart, size);
	}
	public static void main(String...strings)
	{
		int[] a={101,34,24,50,61,71,32,2,1};
		mergeSort(a);
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
	}
}
