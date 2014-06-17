 $(document).ready(function(){
     $("#order").change(function(){
         document.getElementById("offset").value = 0;
         $("#formPagination").submit();
     });
     $("#paginas li").click(function(e){
         e.preventDefault();
         var id = $(this).attr('id');
         if(id!="offset-x")
         {
             var offset = id.split('-');
             if(offset[1] == 'a')
             {
                 document.getElementById("offset").value = parseInt(document.getElementById("offset").value) - 1;
             }
             else if(offset[1] == 'l')
             {
                 document.getElementById("offset").value = parseInt(document.getElementById("offset").value) + 1;
             }
             else
             {
                 document.getElementById("offset").value = parseInt(document.getElementById("offset").value) + parseInt(offset[2]);
             }
             $("#formPagination").submit();
         }
     });
 });