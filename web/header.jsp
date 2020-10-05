<%-- 
    Document   : header
    Created on : Apr 7, 2020, 6:52:31 PM
    Author     : Arpit mishra
--%>

<header class="header-section">
		<div class="header-top">
			<div class="container">
				<div class="row">
					<div class="col-lg-2 text-center text-lg-left">
						<!-- logo -->
						<a href="home.jsp" class="site-logo">
							<img src="img/LOGO2.png" alt="">
						</a>
					</div>
					<div class="col-xl-6 col-lg-5">
						<form class="header-search-form">
							<input type="text" placeholder="Search on online fasion store ....">
							<button><i class="flaticon-search"></i></button>
						</form>
					</div>
					<div class="col-xl-4 col-lg-5">
						<div class="user-panel">
							<div class="up-item">
								<i class="flaticon-profile"></i>
								<a href="login.jsp">Sign</a> In or <a href="Registration.jsp">Create Account</a>
							</div>
							<div class="up-item">
								<div class="shopping-card">
									<i class="flaticon-bag"></i>
									<span>0</span>
								</div>
								<a href="cart.jsp">Shopping Cart</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<nav class="main-navbar">
			<div class="container">
				<!-- menu -->
				<ul class="main-menu">
					<li><a href="home.jsp">Home</a></li>
					<li><a href="#">Women</a></li>
					<li><a href="#">Men</a></li>
					<li><a href="#">Kids</a></li>
				
					</a></li>
					<li><a href="#">Shoes</a>
						<ul class="sub-menu">
							<li><a href="#">Sneakers</a></li>
							<li><a href="#">Sandals</a></li>
							<li><a href="#">Formal Shoes</a></li>
							<li><a href="#">Boots</a></li>
							<li><a href="#">Flip Flops</a></li>
						</ul>
					</li>
					<li><a href="#">Pages</a>
						<ul class="sub-menu">
							<li><a href="./product.jsp">Product Page</a></li>
							<li><a href="./category.jsp">Category Page</a></li>
							<li><a href="./cart.jsp">Cart Page</a></li>
							<li><a href="./checkout.jsp">Checkout Page</a></li>
							<li><a href="./contact.jsp">Contact Page</a></li>
						</ul>
					</li>
					<li><a href="#">My Order</a>
						<ul class="sub-menu">
							<li><a href="#">Return</a></li>
							<li><a href="#">Shipping</a></li>
							<li><a href="#">Track Order</a></li>
							<li><a href="#">Account</a></li>
							
						</ul>
					</li>
					
				</ul>
			</div>
		</nav>
	</header>