let [regex_arr,ans] = [[], new Set()];
function swap(user_id,a,b) {
    let temp = user_id[a];
    user_id[a] = user_id[b];
    user_id[b] = temp;
    return 1;
}

function perm(user_id,N,d) {
    if(d == N) {
        ans.add(user_id.slice(0,N).sort().toString());
        return 1;
    }
    for(let i=d; i<user_id.length; i++) {
		regex_arr[d].test(user_id[i]) && swap(user_id,d,i) && perm(user_id, N, d+1) && swap(user_id,d,i);
	}
    return 1;
}

function solution(user_id, banned_id) {
    regex_arr = banned_id.map((item)=> new RegExp(`^(${item.split("").map((item)=> item=="*" ? "\\w{1}" : item).join("")})$`));
    perm(user_id, banned_id.length, 0);
    return ans.size;
}