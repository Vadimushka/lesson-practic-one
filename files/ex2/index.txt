<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>Практическое занятие № 1</title>
	<link href="/css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
<div class="container">
	<div class="header">
		<a href="/"><img src="/images/max_logo.png" alt="Учебная практика"></a>
	</div>
	<div class="sidebar1">
		<ul class="nav">
			<li><a href="/less-1" title="Практическая работа № 1">1 работа</a></li>
			<li><a href="/less-2" title="Практическая работа № 2">2 работа</a></li>
			<li><a href="/less-3" title="Практическая работа № 3">3 работа</a></li>
			<li><a href="/less-4" title="Практическая работа № 4">4 работа</a></li>
			<li><a href="/less-5" title="Практическая работа № 5">5 работа</a></li>
			<li><a href="/less-6" title="Практическая работа № 6">6 работа</a></li>
			<hr>
			<li><a href="/less-new" title="Практическая работа № 1">1 работа</a></li>
		</ul>
	</div>

	<div class="content">
		<div style="text-align: center;"><h1>Практическое занятие # 1</h1></div>
		<p><strong>Задание: </strong></p>
		<p>Организовать формирование двухмерного числового массива запросом количества строк и столбцов
			и заполнения целыми случайными числами, используя генератор случайных чисел и его опции.<br>
			Провести статистическую обработку массива:</p>
		<ul>
			<li>Вычислить и вывести сумму</li>
			<li>Найти среднее арифметичекое</li>
			<li>Найти минимальный элемент</li>
			<li>Найти максимальный элемент</li>
			<li>Найти среднее арифметичекое по алгоритму: (минимум + максимум)/2</li>
			<li>Определить разницу для этих двух средних</li>
		</ul>

		<hr>
		<form method="post">
			<p>Введите числа ниже: </p>
			<p>Количество строк: <label><input type="number" name="rows"></label></p>
			<p>Количество столбцов: <label><input type="number" name="cols"></label></p>
			<p><input type="submit" name="button"></p>
		</form>

		<?php
		if (isset($_POST['button'])) {
			echo "<hr>";
			$rows = $_POST['rows'];
			$cols = $_POST['cols'];

			$c = 0;
			$sum = 0;

			$arr_int = array();
			for($x = 0; $x < $rows; $x++){
				for($y = 0; $y < $cols; $y++){
					$arr_int[$x][$y] = rand(-100, 100);
				}
			}

			$min = $max = $arr_int[0][0];

			echo "<div style='padding-left: 15px'>";
			echo "<p>Полученный массив:</p>";
			echo "<table border='1'>";
			foreach($arr_int as $rInt){
				$c += count($rInt);
				$sum += array_sum($rInt);

				echo "<tr>";
				foreach ($rInt as $value){
					echo "<td>{$value}</td>";
				}
				echo "</tr>";

				if($max < max($rInt)){
					$max = max($rInt);
				}
				if($min > min($rInt)){
					$min = min($rInt);
				}
			}
			echo "</table>";
			echo "</div>";

			echo "<br><p>Сумма массива = " . $sum . "</p>";
			$averageOne = $sum / $c;
			echo "<p>1 Среднее в  массиве = " . $averageOne . "</p>";

			echo "<p>Максимальное значение массива =" . $max . "</p>";
			echo "<p>Минимальное значение массива = " . $min ."</p>";
			$averageTwo = ($max + $min)/2;
			echo "<p>2 Среднее в  массиве = " . $averageTwo . "</p>";

			echo "<p>Разница между 1 и 2 средних значение = " . ($averageOne - $averageTwo) . "</p>";

			echo "<p><a href='/less-1'>Убрать все</a></p>";
		}
		?>



	</div>

	<div class="footer">
		<div style="text-align: center;"><p>2015 &copy; vadimushka_d | Вадим Дунькин | гр. 13ОИТ18к</p></div>
	</div>
</div>
</body>
</html>
