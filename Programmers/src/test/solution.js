function parse(route, path) {
  /* 작성해주세요 */
  const routeArr = route.split("/");
  const pathArr = path.split("/");

  let m = true;
  let p = {};
  if(pathArr.length===1 && routeArr.length===1) {
    m = true;
  } else if(routeArr.length ===1) {
    m = true;
  } else if(pathArr.length ===1) {
    m = false 
  } else if(pathArr.length > routeArr.length) {
    m = false
  }
  else {
    for(let i=1; i<routeArr.length; i++) {
      if(i%2==1) {
        if(i < pathArr.length && routeArr[i] !== pathArr[i]) {
          m = false;
          break;
        }
      } else {
        if(i<pathArr.length) {
          p[routeArr[i].substring(1, routeArr[i].length-1)] = pathArr[i];
        }
      }
    }
  }

  if(m) {
    return {
      matches: m,
      params : p
    } 
  } else {
    return {
      matches: m,
    }
  }


}

function solution(route, path) {
  var result = parse(route, path);
  return JSON.stringify(result);
}

solution("/service/[id]/develop")