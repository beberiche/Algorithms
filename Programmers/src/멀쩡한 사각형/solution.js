const calc = (x,y,sqr) => {
  for(let i=1; i<x; i++) sqr+=parseInt(y*i/x) 
  return sqr*2
};
const solution = (w, h) => w<h ? calc(w,h,0) : calc(h,w,0);