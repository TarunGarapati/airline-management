/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$("#date").datepicker({
  onSelect: function(date) {
    $(".date").find("h4").text(date);
  }
});

