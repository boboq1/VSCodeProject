package JavaDemo.数组中数字出现的次数;
public class Solution{
    /*
    &: 1001&0001 = 0001
    ^: 1001^0001 = 1000
    */
    //位运算
    public int[] singleNumbers(final int[] nums) {
        int mask = 1;// 两数经过异或运算后最靠近右边的二进制1
        int a = 0, b = 0;// 存储两个不同的数
        // 确定那两个数异或运算后不同的位即为1的位
        int sum = 0;
        for (final int num : nums) {
            sum ^= num;
        }
        while ((sum & mask) == 0) {
            mask <<= 1;
        }
        for (final int num : nums) {
            if((num&mask)==0){
                a ^= num;
            }else{//(num&mask)==mask 
                b ^= num;
            }
        }
    
        return new int[] {a,b};
    }
}