package com.trabajo.Grupo16OO22021.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.trabajo.Grupo16OO22021.entities.PermisoDiario;
import com.trabajo.Grupo16OO22021.entities.PermisoPeriodo;
import com.trabajo.Grupo16OO22021.repositories.IPermisoDiarioRepository;
import com.trabajo.Grupo16OO22021.repositories.IPermisoPeriodoRepository;
import com.trabajo.Grupo16OO22021.services.QRCodeService;

@RestController
public class QRCodeController {

	private final int WIDTH = 250;
	private final int HEIGHT = 250;

	@Autowired
	private QRCodeService qrCodeService;

	@Autowired
	@Qualifier("permisoPeriodoRepository")
	private IPermisoPeriodoRepository permisoPeriodoRepository;
	
	@Autowired
	@Qualifier("permisoDiarioRepository")
	private IPermisoDiarioRepository permisoDiarioRepository;


	@GetMapping("/qr-code{id}")
	public ResponseEntity<byte[]> getQrCode(@PathVariable("id") int id) {
		Optional<PermisoPeriodo> permiso = permisoPeriodoRepository.findById(id);
		byte[] qrImage = qrCodeService.generate(permiso.toString(), WIDTH, HEIGHT);

		return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(qrImage);
	}
	
	@GetMapping("/qrcode{id}")
	public ResponseEntity<byte[]> getQrCode1(@PathVariable("id") int id) {
		Optional<PermisoDiario> permiso = permisoDiarioRepository.findById(id);
		byte[] qrImage = qrCodeService.generate(permiso.toString(), WIDTH, HEIGHT);

		return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(qrImage);
	}
}