 package JavaDemo.山脉数组中查找目标值;
 
    
    
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        if(mountainArr.length()<=2) return -1;
        //首先找出最大值，将数组分为升序和降序的两部分，利用二分查找分别查找target
        int pre = 0 ,last = mountainArr.length()-1;
        while(pre+1<last){
            int mid =(last+pre)/2;
            int midVal = mountainArr.get(mid);
            if(midVal>mountainArr.get(mid-1)){
                 pre = mid;
            }else{
                last = mid;
            }
        }
            int maxIndex = mountainArr.get(last)>mountainArr.get(pre)?last:pre;
            int index = binaryFind(target,mountainArr,0,maxIndex,true);
            return index != -1?index:binaryFind(target,mountainArr,maxIndex+1,mountainArr.length()-1,false);
      }
        private int binaryFind(int target,MountainArray mountainArr,int pre,int last, boolean isPre){
            
            while(pre<=last){
                int mid = (last+pre)/2;
                int midVal = mountainArr.get(mid);
                if(target == midVal){
                    return mid;
                }
                if(target>midVal){
                    pre = isPre?mid+1:pre;
                    last = isPre?last:mid-1;
                }else{
                    
                    last = isPre?mid-1:last;
                     pre = isPre?pre:mid+1;
                }
            }
            return -1;
        }
        
    }