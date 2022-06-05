// O(lgn)
// consider negative y
float power(float x, int y) {
    float temp;
    if (y< 0)
        return 1/power(x, -y);
    if( y == 0)
       return 1;
    temp = power(x, y>>1);
    if (y&1 == 0)
        return temp*temp;
    else
        return y>0? temp*temp*x: temp*temp/x;
} 

public double power(double x, int n) {
    if (n < 0) return 1.0/power(x, -n);
    double r = 1.0, pow = x;
    while (n > 0) {
        if ( (1 & n) > 0 ) r *= pow;
        n >>= 1;
        pow *= pow;
    }
    return r;
}

bool isPowerOf(int n, int k) {
    if (n < 1 || k < 1)
        return false;
    if (k == 1)
        return true;
    
    while (1) {
        if (n%k !=0)
            return false;
        if (n == 1)
            return true;
        n/= k;
    } 
    return false;
}