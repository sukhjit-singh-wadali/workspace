package com.walnut.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.walnut.model.AbstractResponse;
import com.walnut.utils.RunnerService;
import com.walnut.utils.RunnerService.RunnerCallback;

@RestController
public class RunnerController {

	@PostMapping("/runner")
	@ResponseBody
	public DeferredResult<ResponseEntity<AbstractResponse>> GetQuestion1(@RequestBody String code) {

		DeferredResult<ResponseEntity<AbstractResponse>> deferredResult = new DeferredResult<ResponseEntity<AbstractResponse>>(
				5000l);

		RunnerService.run(code, new RunnerCallback() {

			@Override
			public void output(String str) {
				AbstractResponse abstractResponse = new AbstractResponse();
				abstractResponse.setMessage(str);
				ResponseEntity<AbstractResponse> result = new ResponseEntity<AbstractResponse>(abstractResponse,
						HttpStatus.OK);

				deferredResult.setResult(result);
			}
		});
		
		
		return deferredResult;
	}
}
