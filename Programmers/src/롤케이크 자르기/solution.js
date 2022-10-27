function solution(topping) {
    let cnt = 0;
    for(let i=0; i<topping.length; i++) new Set(topping.slice(0,i)).size === new Set(topping.slice(i)).size && cnt++;
    return cnt;
}

console.log(solution([1, 2, 3, 1, 4]));