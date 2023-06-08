var fulldoc='';
var scrollX=0;
var scrollY=0;

document.addEventListener("keydown",function(event){
    if(event.key=='q' && event.altKey){
        fulldoc=document.body.outerHTML;
        scrollY=window.pageYOffset;
        scrollX=window.pageXOffset;
    }
    if(event.key=='w' && event.altKey){
        document.body.outerHTML=fulldoc;
        document.body.scrollTo(scrollX,scrollY);
    }
});

Second option 
 or use Selector hub bebug function 

Third option is 
Remove the Click Event and Blur Event in browser 


When the window looks the way you would want to scan, press 'Alt + Q', then press 'Alt + W'. Now your window will freeze and then you can scan your page. To steer the objects you need to refresh your browser.
