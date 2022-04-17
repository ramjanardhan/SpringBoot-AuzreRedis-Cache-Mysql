package com.redis.Redis.Service;
/**
 * @author Janardhan Randhi
 * website www.quickdevops.com
 *
 */
import java.util.List;

import com.redis.Redis.Entity.Invoice;

public interface InvoiceService {

	public Invoice saveInvoice(Invoice inv);

	public Invoice updateInvoice(Invoice inv, Integer invId);

	public void deleteInvoice(Integer invId);

	public Invoice getOneInvoice(Integer invId);

	public List<Invoice> getAllInvoices();
}