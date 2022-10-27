function solution(want, number, discount) {
  let cnt = 0;
  for(let i=0; i<discount.length; i++) {
      const newNumber = i+10<discount.length ? simulation([...number],want,discount,i, i+10) : simulation([...number],want,discount,i, discount.length);
      if(checkCal(newNumber)) cnt++;
  }
  return cnt;
}

function simulation(newNumber, want, discount,start, end) {
  for(let j=start; j<end;j++) {
    let idx= want.indexOf(discount[j]);
    newNumber[idx]--;
  }
  return newNumber; 
}

function checkCal(newNumber) {
  let check = true;
  for(let j=0; j<newNumber.length; j++) {
    if(newNumber[j] > 0) {
      check = false;
      break;
    }
  }
  return check;
}

console.log(solution(["banana", "apple", "rice", "pork", "pot"],[3, 2, 2, 2, 1],["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"]))