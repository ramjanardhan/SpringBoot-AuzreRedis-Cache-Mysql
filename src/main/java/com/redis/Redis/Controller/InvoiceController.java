package com.redis.Redis.Controller;
/**
 * @author Janardhan Randhi
 * website www.quickdevops.com
 *
 */
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.Redis.Entity.Invoice;
import com.redis.Redis.Service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;

	@PostMapping("/saveInv")
	public Invoice saveInvoice(@RequestBody Invoice inv) {
		return invoiceService.saveInvoice(inv);
	}

	@GetMapping("/allInv")
	public ResponseEntity<List<Invoice>> getAllInvoices() {
		return ResponseEntity.ok(invoiceService.getAllInvoices());
	}

	@GetMapping("/getOne/{id}")
	public Invoice getOneInvoice(@PathVariable Integer id) {
		return invoiceService.getOneInvoice(id);
	}

	@PutMapping("/modify/{id}")
	public Invoice updateInvoice(@RequestBody Invoice inv, @PathVariable Integer id) {
		return invoiceService.updateInvoice(inv, id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteInvoice(@PathVariable Integer id) {
		invoiceService.deleteInvoice(id);
		return "Employee with id: " + id + " Deleted !";
	}

	@Resource
	private StringRedisTemplate template;

	@RequestMapping("/")
	// Define the Hello World controller.
	public String hello() {
		ValueOperations<String, String> ops = this.template.opsForValue();
		// Add a Hello World string to your cache.
		String key = "JanardhanRandhi";
		if (!this.template.hasKey(key)) {
			ops.set(key, "Hello Janardhan Randhi!");
		}
		// Return the string from your cache.
		return ops.get(key);
	}
}