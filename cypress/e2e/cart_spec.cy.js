describe('Cart Test', () => {
    // beforeEach: Chạy trước mỗi bài test (để đỡ phải viết lại đoạn login)
    beforeEach(() => {
        cy.visit('https://www.saucedemo.com');
        cy.get('#user-name').type('standard_user');
        cy.get('#password').type('secret_sauce');
        cy.get('#login-button').click();
    });

    // Kịch bản 3: Thêm sản phẩm vào giỏ
    it('Should add a product to the cart', () => {
        // Tìm sản phẩm đầu tiên và click nút Add to cart
        cy.get('.inventory_item').first().find('.btn_inventory').click();

        // Kiểm tra số 1 xuất hiện trên icon giỏ hàng
        cy.get('.shopping_cart_badge').should('have.text', '1');
    });

    // Kịch bản 4: Sắp xếp sản phẩm (Low to High)
    it('Should sort products by price low to high', () => {
        cy.get('.product_sort_container').select('lohi');

        // Kiểm tra giá sản phẩm đầu tiên là $7.99
        cy.get('.inventory_item_price').first().should('have.text', '$7.99');
    });

    // --- PHẦN BÀI TẬP LÀM THÊM ---

    // Yêu cầu 1: Kiểm tra chức năng xóa sản phẩm khỏi giỏ hàng
    it('Should remove a product from the cart', () => {
        // B1: Thêm vào giỏ trước
        cy.get('.inventory_item').first().find('.btn_inventory').click();
        cy.get('.shopping_cart_badge').should('have.text', '1');

        // B2: Nhấn nút Remove (Sau khi thêm, nút Add đổi thành nút Remove)
        // Cách 1: Click lại vào nút đó (class btn_inventory vẫn giữ nguyên, chỉ đổi text)
        cy.contains('Remove').click();

        // B3: Xác minh giỏ hàng về 0 (badge biến mất)
        cy.get('.shopping_cart_badge').should('not.exist');
    });

    // Yêu cầu 2: Kiểm tra quy trình thanh toán
    it('Should complete the checkout flow', () => {
        // B1: Thêm sản phẩm
        cy.get('.inventory_item').first().find('.btn_inventory').click();

        // B2: Đi đến trang giỏ hàng
        cy.get('.shopping_cart_link').click();
        cy.url().should('include', '/cart.html');

        // B3: Nhấn Checkout
        cy.get('#checkout').click();

        // B4: Điền thông tin
        cy.get('#first-name').type('John');
        cy.get('#last-name').type('Doe');
        cy.get('#postal-code').type('12345');

        // B5: Nhấn Continue
        cy.get('#continue').click();

        // B6: Xác minh chuyển đến trang xác nhận (step two)
        cy.url().should('include', '/checkout-step-two.html');
    });
});