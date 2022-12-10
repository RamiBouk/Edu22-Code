<?php
//tp8serverGet.php
$clients = [
	[  
		'uid' => 16,
		'name' => 'Adem',
		'age' => 8,
		'email' => 'Adem@gmail.com'
	],
	[
		'uid' => 10,
		'name' => 'Omar',
		'age' => 24,
		'email' => 'Omar@gmail.com'
	],
	[
		'uid' => 30,
		'name' => 'Hafsa',
		'age' => 1,
		'email' => 'Hafsa@gmail.com'
	]
];
	function search($key,$pval,$clients){


		foreach ($clients as $ky=>$val) {
			if($val[$key]==$pval)
				return $ky;
    }
		return false;
	}
$x=search('uid',30,$clients);
error_log(var_export($x, true));
	print_r($x);


?>
