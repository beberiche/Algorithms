function gcd(a,b) {
    return b ? gcd(b,a%b) : a;
}

function check(num, arr) {
    for(let i=0; i<arr.length; i++) 
        if(arr[i]%num == 0) return false;
    return true;
}

function solution(arrayA, arrayB) {
    let answer = 0;
    let [resultA, resultB] = [-1,-1];

    [resultA, resultB] = [arrayA[0],arrayB[0]];
    for(let i=1; i<arrayA.length; i++) {
        [resultA,resultB] = [gcd(resultA, arrayA[i]),gcd(resultB, arrayB[i])];
    }
    
    const [a_check, b_check] = [resultA == 1 ? false : check(resultA, arrayB), resultB == 1 ? false : check(resultB, arrayA)];
    return a_check && b_check ? Math.max(resultA, resultB) : a_check ? resultA : b_check ? resultB : 0;
}
