CREATE OR REPLACE FUNCTION borrow_book(p_inventory_id INTEGER, p_user_id INTEGER, p_borrow_date DATE)
    RETURNS VOID AS $$
BEGIN
    -- Insert a new record into the borrowing_record table
    INSERT INTO borrowing_record (user_id, inventory_id, borrowing_time)
    VALUES (p_user_id, p_inventory_id, p_borrow_date);

    -- Update the status column of the inventory table
    UPDATE inventory
    SET status = 'borrowed'
    WHERE inventory_id = p_inventory_id;
END;
$$ LANGUAGE plpgsql;

