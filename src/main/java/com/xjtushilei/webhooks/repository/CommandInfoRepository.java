package com.xjtushilei.webhooks.repository;

import com.xjtushilei.webhooks.entity.CommandInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommandInfoRepository extends JpaRepository<CommandInfo, Long> {

	/**
	 * 根据命令名称查询
	 * @param name
	 * @return
	 */
	CommandInfo findByName(String name);

}