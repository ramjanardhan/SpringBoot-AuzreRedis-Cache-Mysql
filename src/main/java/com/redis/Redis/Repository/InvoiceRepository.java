package com.redis.Redis.Repository;
/**
 * @author Janardhan Randhi
 * website www.quickdevops.com
 *
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redis.Redis.Entity.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
