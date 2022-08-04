function solution(codeOwnersMap, directory) {
  // if(typeof codeOwnersMap.directory === "Array") {
  //     return co
  // } else if(typeof codeOwnersMap.directory === "Object") {

  // }
  if(directory.includes("/")) {
      const arr = [r1, r2, r3, r4, r5] = directory.split("/");
      let answer = codeOwnersMap[r1];
      for(let i=1; i<5; i++) {
        if(arr[i]){
          answer = answer[arr[i]];
        } else {
          break
        }
      }
      return answer
  } else {
      return codeOwnersMap[directory]
  }
}

const codeOwnersMap = {
  "scripts" : ["배수진"],
  "services": {
    "business-ledger" : ["고찬균","배수진"],
    "toss-card" : ["채주민", "유재섭"],
    "payments": ["유재섭"],
  }
}
console.log(solution(codeOwnersMap, "services/business-ledger"))